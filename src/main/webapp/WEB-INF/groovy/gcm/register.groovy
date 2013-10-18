import com.google.appengine.api.datastore.*
import groovy.json.*
import util.*

import com.google.appengine.api.datastore.*

def status = ""
def code = ""
def message = ""

if (!params.regId || !params.email || !params.password || !params.name) {
  status = "ERROR"
  code = "99"
  message = "INVALID PARAMETERS"  
} else {
  def usr = datastore.execute {
	  select single password
	  from 'user'
	  where 'email' == params.email
  }
  if (usr !=null && usr.password != params.password) {
      status = "ERROR"
      code = "01"
      message = "INVALID PASSWORD"
  } else {
    if (usr == null) {
      def u = new Entity("user")
      u.email = params.email
      u.password = params.password
      u.dateCreated = (new Clock()).getDateTime()
      u.save()	
    }
    
    device = datastore.execute {
	    select single email
	    from 'gcm_device'
	    where regId == params.regId
    }
      
    if (device != null) {
      if (device.email != params.email) {
        status = "ERROR"
        code = "02"
        message = "DEVICE ALREADY REGISTERED FOR ANOTHER USER"
      } else {
        status = "ERROR"      
        code = "03"
        message = "DEVICE ALREADY REGISTERED FOR THIS USER"
      }
    } else {
      device = datastore.execute {
	      select count
	      from 'gcm_device'
	      where name == params.name
	      and email == params.email
      }
      if (device > 0) {
        status = "ERROR"
        code = "04"
        message = "DEVICE NAME ALREADY EXISTS"
      }
    }
    
    if (status != "ERROR") {
      def e = new Entity("gcm_device")
      e.email = params.email
      e.regId = params.regId
      e.name = params.name      
      e.dateCreated = (new Clock()).getDateTime()
      e.save()	
      code = "00"
      message = "DEVICE REGISTERED OK"
    }
  }
}


def json = new JsonBuilder([status:status, code: code, message: message])
println JsonOutput.prettyPrint(json.toString())
  

import com.google.appengine.api.datastore.*
import groovy.json.*
import util.*

import com.google.appengine.api.datastore.*

def status = "OK"
def message = ""

if (!params.regId || !params.email || !params.password || !params.name) {
  status = "ERROR"
  message = "INVALID PARAMETERS"  
} else {
  def usr = datastore.execute {
	  select single password
	  from 'user'
	  where 'email' == params.email
  }
  if (usr !=null && usr.password != params.password) {
      status = "ERROR"
      message = "INVALID PASSWORD"
  } else {
    def u = new Entity("user")
    u.email = params.email
    u.password = params.password
    u.dateCreated = (new Clock()).getDateTime()
    u.save()	
    
    device = datastore.execute {
	    select single email
	    from 'gcm_device'
	    where regId == params.regId
    }
      
    if (device != null) {
      status = "ERROR"
      if (device.email != params.email) {
        message = "DEVICE ALREADY REGISTERED FOR ANOTHER USER"
      } else {
        message = "DEVICE ALREADY REGISTERED FOR THIS USER"
      }
    }

    if (status == "OK") {
      def e = new Entity("gcm_device")
      e.email = params.email
      e.regId = params.regId
      e.dateCreated = (new Clock()).getDateTime()
      e.save()	
      message = "DEVICE REGISTERED OK"
    }
  }
}


def json = new JsonBuilder([status:status, message: message])
println JsonOutput.prettyPrint(json.toString())
  

import groovy.json.*

def status = ""
def code  = ""
def message = ""

if (params.email && params.password) {
  def usr = datastore.execute {
    select single password
    from 'user'
    where 'email' == params.email
  }
  if (usr == null) {
    status = "ERROR"
    code = "01"
    message = "USER NOT FOUND"
  } else {
    if (usr.password != params.password) {
      status = "ERROR"    
      code = "02"
      message = "INVALID PASSWORD"
    } else {
      status = "OK"
      code = "00"
      message = "SUCCESS"
      memcache['userEmail'] = params.email
    }
  }
}

//TODO colocar login num log de eventos

def json = new JsonBuilder([status:status, code: code, message: message])
println JsonOutput.prettyPrint(json.toString())
  
/*
forward "/WEB-INF/pages/list.gtpl"

import com.google.appengine.api.datastore.*

if (session.getAttribute("user") == null) {
	redirect "/"
} else {
  user = session.getAttribute("user")

  devices = datastore.execute {
	  select regId:String, name:String
	  from "gcm_device"
	  where email == user.email
  }

  devices.each { d->
    println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a>"
  }

  println "<br>${devices.size()} dispositivo(s) registrados no total."
}*/

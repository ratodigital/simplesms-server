import com.google.appengine.api.datastore.*


if (!memcache["userEmail"]) {
	redirect "/"
} else {

  request.devices = datastore.execute {
	  select regId:String, name:String
	  from "gcm_device"
	  where email == memcache["userEmail"]
  }

  forward "/WEB-INF/pages/list.gtpl"
/*
  devices.each { d->
    println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a>"
  }

  println "<br>${devices.size()} dispositivo(s) registrados no total."
*/
  
}

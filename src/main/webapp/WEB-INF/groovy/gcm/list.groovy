import com.google.appengine.api.datastore.*

devices = datastore.execute {
	select all from "gcm_device"
}

devices.each { d->
  println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a>"
}

println "<br>${devices.size()} dispositivo(s) registrados no total."

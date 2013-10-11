import com.google.appengine.api.datastore.*

if (session.user == null) {
	redirect "/"
} 


devices = datastore.execute {
	select regId, name, from "gcm_device"
	where email = session.user.email
}

devices.each { d->
  println "$d.name -> $d.regId <a href=\"/gcm/send?regId=$d.regId\">send 'a new message'</a>"
}

println "<br>${devices.size()} dispositivo(s) registrados no total."

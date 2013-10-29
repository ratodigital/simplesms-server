import util.*
import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def gcm = new GoogleGCM()
  def model = new Messages()
  def phones = params.phone as String[]  
  def msgId = model.add(params.device, params.message, phones.join(","))

  def result = gcm.send(params.device, "NEW_MESSAGE", msgId.getId())
  if (result.success == 1) {
    println "MESSAGE ${msgId.getId()} SENT TO $params.regId<hr>TITLE: $params.title<hr>MESSAGE:$params.message"
  } else {
    println "ERROR $result"
  }
}





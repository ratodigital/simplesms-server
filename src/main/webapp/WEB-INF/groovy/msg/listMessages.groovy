import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Messages()
  request.messages = model.list()

  forward '/WEB-INF/pages/messages.gtpl'
}

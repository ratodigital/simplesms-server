import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Phones()
  request.tels = model.list()

  forward '/WEB-INF/pages/tels.gtpl'
}

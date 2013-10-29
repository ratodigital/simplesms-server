import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Groups()
  request.groups = model.list()

  forward '/WEB-INF/pages/groups.gtpl'
}

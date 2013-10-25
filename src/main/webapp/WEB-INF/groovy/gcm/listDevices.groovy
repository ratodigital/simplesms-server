import model.*
if (!memcache["userEmail"]) {
	redirect "/"
} else {
	def model = new Devices()
	request.devices = model.list()
  forward "/WEB-INF/pages/list.gtpl"
}

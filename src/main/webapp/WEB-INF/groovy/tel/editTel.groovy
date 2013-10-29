import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Phones()
  request.tel = model.get(params.id)
  
  def groupModel = new Groups()
  request.groups = groupModel.list()
  
  forward '/WEB-INF/pages/tel.gtpl'
}


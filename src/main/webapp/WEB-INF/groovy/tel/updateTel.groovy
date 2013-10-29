import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Phones()
  def tel = model.update(params.id, params.number, params.name, params.groups)
  //println params
  forward '/tel/listTel.groovy'
}





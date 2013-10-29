import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Phones()
  model.add(params.number, params.name, params.groups)

  forward '/tel/listTel.groovy'
}

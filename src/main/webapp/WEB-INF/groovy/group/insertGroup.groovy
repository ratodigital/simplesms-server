import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Groups()
  model.add(params.name, params.description)

  forward '/group/listGroup.groovy'
}

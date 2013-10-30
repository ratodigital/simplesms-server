import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Contacts()
  model.add(params.name, params.phone, params.groups)

  redirect '/contact/listContact.groovy'
}

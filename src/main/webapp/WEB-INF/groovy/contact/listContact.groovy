import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  request.contacts = new Contacts().list()

  forward '/WEB-INF/pages/contacts.gtpl'
}

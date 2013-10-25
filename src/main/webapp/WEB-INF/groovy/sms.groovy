import model.*
if (!memcache["userEmail"]) {
	redirect "/"
} else {
	request.devices = new Devices().list()
	
	request.phones = new Phones().list()
		
  forward "/WEB-INF/pages/sms.gtpl"
}

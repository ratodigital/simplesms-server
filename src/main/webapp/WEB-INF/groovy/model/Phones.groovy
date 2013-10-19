package model

import com.google.appengine.api.datastore.*
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Phones {

	def list() {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select all
	 	 	from phone
			where email == userEmail
			sort asc by name
  	}
	}

	def delete(id) {
		Key key = KeyFactory.createKey("phone", Long.parseLong(id))
		key.delete()
	}

	def add(number, name) {
    def u = new Entity("phone")
		u.email = memcache['userEmail']
    u.number = number
    u.name = name
    u.dateCreated = (new Clock()).getDateTime()
    u.save()	
	}

}

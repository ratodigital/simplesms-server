package model

import com.google.appengine.api.datastore.*
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Users {

	def getPassword(userEmail) {
		datastore.execute {
	  	select single password
	 	 	from user
	  	where email == userEmail
  	}
	}

	def add(email, password) {
    def u = new Entity("user")
    u.email = email
    u.password = password
    u.dateCreated = (new Clock()).getDateTime()
    u.save()	
	}

}

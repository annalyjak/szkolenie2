package pl.ultimo.qdoc.services.qdocfinder;


import pl.ultimo.qdoc.services.qdocflow.domain.produces.QDocWasCreated;
import pl.ultimo.qdoc.services.qdocflow.domain.produces.QDocWasVerified;

public class DomainEventListener {


	void lintenOn(QDocWasCreated event) {

		// insert into qdoc_read_model event.id, "Untitled", ...
	}

	void lintenOn(QDocWasVerified event) {

		// update qdoc_read_model where id = event.id set status = "Verified"
	}


}

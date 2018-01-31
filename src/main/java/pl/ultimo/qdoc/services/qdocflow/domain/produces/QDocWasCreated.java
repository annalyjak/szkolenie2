package pl.ultimo.qdoc.services.qdocflow.domain.produces;

import pl.ultimo.qdoc.services.shared.DomainEvent;
import pl.ultimo.qdoc.services.shared.QDocId;
import pl.ultimo.qdoc.services.shared.QmId;

import java.time.LocalDateTime;
import java.util.Objects;

public class QDocWasCreated implements DomainEvent{

	private final QDocId  qDocId;
	private final LocalDateTime creationDate;
	private final String qdocNumber;
	private final QmId  authorId;
	private final String qDocType;

	public QDocWasCreated(QDocId qDocId, LocalDateTime creationDate, String qdocNumber, QmId authorId, String qDocType) {
		this.qDocId = qDocId;
		this.creationDate = creationDate;
		this.qdocNumber = qdocNumber;
		this.authorId = authorId;
		this.qDocType = qDocType;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("QDocWasCreated{");
		sb.append("qDocId=").append(qDocId);
		sb.append(", creationDate=").append(creationDate);
		sb.append(", qdocNumber='").append(qdocNumber).append('\'');
		sb.append(", authorId=").append(authorId);
		sb.append(", qDocType='").append(qDocType).append('\'');
		sb.append('}');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		QDocWasCreated that = (QDocWasCreated) o;
		return Objects.equals(qDocId, that.qDocId) &&
				Objects.equals(creationDate, that.creationDate) &&
				Objects.equals(qdocNumber, that.qdocNumber) &&
				Objects.equals(authorId, that.authorId) &&
				Objects.equals(qDocType, that.qDocType);
	}

	@Override
	public int hashCode() {

		return Objects.hash(qDocId, creationDate, qdocNumber, authorId, qDocType);
	}
}

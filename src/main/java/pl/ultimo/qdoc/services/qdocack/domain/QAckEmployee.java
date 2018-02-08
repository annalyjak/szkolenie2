package pl.ultimo.qdoc.services.qdocack.domain;

import pl.ultimo.qdoc.services.shared.EmployeeId;
/**
 * @author Anna
 */
public class QAckEmployee {

    EmployeeId employeeId;
    EmployeeId managerId;

    public boolean isEmployeeManager(EmployeeId managerId) {
        return this.managerId.equals(managerId);
    }
}

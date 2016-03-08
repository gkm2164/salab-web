package kr.ac.kaist.salab.model.helper;

import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.repository.RMemberPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by USER on 2016-03-08.
 */
public class PublicationAuthorSortHelper {
    @Autowired
    private RMemberPublicationRepository rmpr;

    public void sortByAuthorOrder(Publication pub) {
        pub.getMemberList().sort(
                (a, b) -> rmpr.findByPublicationAndMember(pub, a).getAuthorOrder()
                        - rmpr.findByPublicationAndMember(pub, b).getAuthorOrder());
    }
}

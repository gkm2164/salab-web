package kr.ac.kaist.salab.model.helper;

import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.RMemberPublication;
import kr.ac.kaist.salab.model.entity.types.PublicationType;
import kr.ac.kaist.salab.model.repository.RMemberPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-03-16.
 */
public class PublicationStringCreationHelper {
    @Autowired
    RMemberPublicationRepository rmpr;

    private boolean isKorean(PublicationType type) {
        switch (type) {
            case SCI_JOURNAL:
            case INTERNATIONAL_CONFERENCE:
            case INTERNATIONAL_JOURNAL:
                return false;
            case DOMESTIC_JOURNAL:
            case DOMESTIC_CONFERENCE:
            default:
                return true;
        }
    }

    public String getString(Publication pub, boolean authorAsALink) {
        List<RMemberPublication> relations = rmpr.findByPublicationOrderByAuthorOrderAsc(pub);

        List<String> authorNameList = new ArrayList<>();

        boolean korean = isKorean(pub.getPublicationType());

        relations.forEach(x -> {
            String prefix = "",
                    postfix = "";

            if (authorAsALink) {
                prefix = String.format("<a href=\"/member/%d/show\">", x.getMember().getId());
                postfix = "</a>";
            }

            String completeString = prefix;
            completeString += (korean ? x.getMember().getKoreanName() : x.getMember().getName());
            completeString += postfix;

            authorNameList.add(completeString);
        });

        String authors = String.join(", ", authorNameList);

        return authors + ", \"" + pub.getTitle() + ",\"" + pub.getMetadata();
    }
}

package com.rest.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.api.data.Count;
import com.rest.api.data.Word;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chou3ibi on 19/08/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WordCountResponse extends  AbstractResponse implements Serializable {

    @Getter
    @Setter
    private List<Count> counts ;

}

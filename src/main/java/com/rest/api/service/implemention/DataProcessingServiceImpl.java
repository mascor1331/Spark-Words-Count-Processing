package com.rest.api.service.implemention;

import com.rest.api.data.Count;
import com.rest.api.data.Word;
import com.rest.api.enums.ErrorCode;
import com.rest.api.model.response.ErrorResponse;
import com.rest.api.model.response.WordCountResponse;
import com.rest.api.service.DataProcessingService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.apache.spark.sql.functions.col;


/**
 * Created by chou3ibi on 19/08/17.
 */

@Service("dataProcessingService")
@Transactional
public class DataProcessingServiceImpl implements DataProcessingService {

    @Autowired
    private SparkSession sparkSession;

    public WordCountResponse getWordsCount(String input) {
        WordCountResponse result = new WordCountResponse();

        if (input.isEmpty()) {
            result.setSuccess(false);
            ErrorResponse errorResponse = new ErrorResponse(ErrorCode.NoContent);
            result.setErrors(errorResponse);
            return result;
        }
        String[] _words = input.split(" ");
        List<Word> words = Arrays.stream(_words).map(Word::new).collect(Collectors.toList());
        Dataset<Row> dataFrame = sparkSession.createDataFrame(words, Word.class);
        dataFrame.show();
        RelationalGroupedDataset groupedDataset = dataFrame.groupBy(col("word"));
        groupedDataset.count().show();
        List<Row> rows = groupedDataset.count().collectAsList();//JavaConversions.asScalaBuffer(words)).count();
        List<Count> counts = rows.stream().map(new Function<Row, Count>() {
            @Override
            public Count apply(Row row) {
                return new Count(row.getString(0), row.getLong(1));
            }
        }).collect(Collectors.toList());

        result.setCounts(counts);
        result.setSuccess(true);
        return result;
    }

    @Override
    public WordCountResponse textClassificationP(String input) {
        return null;
    }
}

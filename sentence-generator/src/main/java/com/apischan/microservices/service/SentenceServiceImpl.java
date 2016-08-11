package com.apischan.microservices.service;

import com.apischan.microservices.domain.Sentence;
import com.apischan.microservices.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

/**
 * Build a sentence by assembling randomly generated subjects, verbs,
 * articles, adjectives, and nouns. The individual parts of speech will
 * be obtained by calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    private WordService wordService;

    @Override
    public String buildSentence() {
        Sentence sentence = new Sentence();
        sentence.addWord(wordService.getSubject());
        sentence.addWord(wordService.getVerb());
        sentence.addWord(wordService.getArticle());
        sentence.addWord(wordService.getAdjective());
        sentence.addWord(wordService.getNoun());
        return sentence.toString();

        //-----------------------------------------------
//        Sentence sentence = new Sentence();
//        Collection<Observable<Word>> observables = createObservables();
//        CountDownLatch countDownLatch = new CountDownLatch(observables.size());
//        Observable.merge(observables)
//                .subscribe(
//                        (word) -> {
//                            sentence.addWord(word);
//                            countDownLatch.countDown();
//                        }
//                );
//
//        waitForAll(countDownLatch);
//
//        return sentence.toString();

    }

    private void waitForAll(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    private Collection<Observable<Word>> createObservables() {
//        return Collections.unmodifiableCollection(Arrays.asList(
//                wordService.getSubject(),
//                wordService.getVerb(),
//                wordService.getArticle(),
//                wordService.getAdjective(),
//                wordService.getNoun()
//        ));
//    }

    @Autowired
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }
}

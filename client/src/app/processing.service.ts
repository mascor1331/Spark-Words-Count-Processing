/**
 * Created by chou3ibi on 26/08/17.
 */

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';

@Injectable()
export class ProcessingService {
  baseUrl: string = '/api/v1/wordsCount/';

  constructor(private http: Http) { }

  wordsCount(terms: Observable<string>) {
  return terms.debounceTime(400)
      .distinctUntilChanged()
      .switchMap(term => this.wordCountEntries(term));
}

  wordCountEntries(term) {
  return this.http
      .get(this.baseUrl  + term)
      .map(res => res.json());
}
}

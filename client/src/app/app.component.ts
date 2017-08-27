import { Component } from '@angular/core';
import { ProcessingService } from './processing.service';
import { Subject } from 'rxjs/Subject';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ProcessingService]
})
export class AppComponent {
  results: Object;
  searchTerm$ = new Subject<string>();

  constructor(private processingService: ProcessingService) {
    this.processingService.wordsCount(this.searchTerm$)
      .subscribe(results => {
        console.log("results: " +results);
        this.results = results.counts;
      });
  }
}

import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {tap, catchError} from "rxjs/operators";
import {CustomResponse} from "../interface/custom-response";

@Injectable({
  providedIn: 'root'
})
export class ServerService {
  private readonly apiUrl = 'any';

  constructor(private http: HttpClient) {}

  servers$ = <Observable<never>>
    this.http.get<CustomResponse>(`${this.apiUrl}/server/list`)
    .pipe(
      tap(console.log),
      catchError(this.handleError)
    );

  handleError(handleError: any): Observable<never> {
    return throwError( 'Method not implemented.');
  }

  /*
  // another way
  getServers(): Observable<CustomResponse>{
    return this.http.get<CustomResponse>(`http://localhost:8080/server/list`);
  }
   */

}

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpService } from './http.service';
import { TruncatePipe } from './truncate.pipe';
import { HttpClientModule } from "@angular/common/http";
import { UserComponent } from './user/user.component';
import { ProductComponent } from './product/product.component';
import { CharacterComponent } from './character/character.component';

@NgModule({
	declarations: [
		AppComponent,
		TruncatePipe,
  UserComponent,
  ProductComponent,
  CharacterComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		FormsModule,
		HttpClientModule
	],
	providers: [
		HttpService
	],
	bootstrap: [
		AppComponent
	]
})
export class AppModule { }

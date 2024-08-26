/** @format */

import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import {
	IonContent,
	IonHeader,
	IonTitle,
	IonToolbar,
	IonCard,
	IonCardHeader,
	IonCardSubtitle,
	IonCardTitle,
	IonCardContent,
	IonItem,
	IonButton,
	IonInput,
} from "@ionic/angular/standalone";
import { Router } from "@angular/router";

@Component({
	selector: "app-login",
	templateUrl: "./login.page.html",
	styleUrls: ["./login.page.scss"],
	standalone: true,
	imports: [
		IonContent,
		IonHeader,
		IonTitle,
		IonToolbar,
		IonCard,
		IonCardHeader,
		IonCardSubtitle,
		IonCardTitle,
		IonCardContent,
		CommonModule,
		FormsModule,
		IonItem,
		IonButton,
		IonInput,
	],
})
export class LoginPage implements OnInit {
	constructor(private router: Router) {}

	ngOnInit() {}

	logMeIn() {
		this.router.navigate(["/home"]);
	}
}

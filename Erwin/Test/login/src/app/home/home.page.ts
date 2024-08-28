/** @format */

import { Component } from "@angular/core";
import {
	IonHeader,
	IonToolbar,
	IonTitle,
	IonContent,
	IonIcon,
	IonCard,
	IonCardContent,
	IonCardHeader,
	IonCardTitle,
	IonItem,
	IonLabel,
	IonInput,
	IonButton,
} from "@ionic/angular/standalone";
import { addIcons } from "ionicons";
import { logoIonic } from "ionicons/icons";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common"; // Import CommonModule

@Component({
	selector: "app-home",
	templateUrl: "home.page.html",
	styleUrls: ["home.page.scss"],
	standalone: true,
	imports: [
		IonHeader,
		IonToolbar,
		IonTitle,
		IonContent,
		IonIcon,
		IonCard,
		IonCardContent,
		IonCardHeader,
		IonCardTitle,
		IonItem,
		IonLabel,
		IonInput,
		IonButton,
		FormsModule,
		CommonModule,
	],
})
export class HomePage {
	greeting: string = "";
	nameValue: string = "";
	isSubmitted: boolean = false;

	constructor() {
		addIcons({ logoIonic });
	}

	onSubmit() {
		if (this.nameValue != "") {
			this.greeting = `Bienvenido, ${this.nameValue}!`;
			this.isSubmitted = true;
		}
	}
}

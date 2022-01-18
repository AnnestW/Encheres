function onClickVentes()

 {
var encheresEnCours = document.getElementById("encheresEnCours");
encheresEnCours.checked = false;
encheresEnCours.disabled = true;
ventesEnCours.disabled = false;
var mesEncheres = document.getElementById("mesEncheres");
mesEncheres.checked = false;
mesEncheres.disabled = true;
ventesNonDebutees.disabled = false;
var encheresRemportees = document.getElementById("encheresRemportees");
encheresRemportees.checked = false;
encheresRemportees.disabled = true;
ventesTerminees.disabled = false;
 }
 
 function onClickAchats()
{
var ventesEnCours = document.getElementById("ventesEnCours");
ventesEnCours.checked = false;
ventesEnCours.disabled = true;
encheresEnCours.disabled = false;
var ventesNonDebutees = document.getElementById("ventesNonDebutees");
ventesNonDebutees.checked = false;
ventesNonDebutees.disabled = true;
mesEncheres.disabled = false;
var ventesTerminees = document.getElementById("ventesTerminees");
ventesTerminees.checked = false;
ventesTerminees.disabled = true;
encheresRemportees.disabled = false;
}
package fr.gregdev.capitalesgame;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class QuizzCapitale extends Quizz implements QuizzInterface {

    private final String MESSAGE_QUESTION = "Quelle est la capitale de ce pays: %s";
    private final ArrayList<String> COUNTRIES_CAPITALES_LIST = this.getListQuizz();
    private final int COUNTRIES_CAPITALES_LIST_SIZE = COUNTRIES_CAPITALES_LIST.size();
    private int numberQuestions;
    private int score;

    public QuizzCapitale() {
	this.numberQuestions = Quizz.selectNumberQuestion();
	this.launch();
    }

    @Override
    public void launch() {
	if (this.numberQuestions <= COUNTRIES_CAPITALES_LIST_SIZE) {
	    game(this.numberQuestions);
	    Quizz.replay();
	} else {
	    JOptionPane.showMessageDialog(null, Quizz.MESSAGE_ERROR_NUMBER_QUESTION + COUNTRIES_CAPITALES_LIST_SIZE);
	    new QuizzCapitale();
	}
    }

    @Override
    public void game(int numberQuestions) {

	// random table of questions and response
	ArrayList<String> listQuizz = Quizz.getRandomTab(COUNTRIES_CAPITALES_LIST, numberQuestions);
	long startTime = System.currentTimeMillis();
	for (int i = 0; i < numberQuestions; i++) {
	    String[] tabQuestionReponse = listQuizz.get(i).split(":");
	    String response = Quizz.withoutAccent(
		    JOptionPane.showInputDialog(String.format(this.MESSAGE_QUESTION, tabQuestionReponse[0])).trim());
	    if (response.equalsIgnoreCase(Quizz.withoutAccent(tabQuestionReponse[1]))) {
		this.score++;
	    }
	}
	long endTime = System.currentTimeMillis();
	JOptionPane.showMessageDialog(null,
		String.format(Quizz.MESSAGE_SCORE, score, numberQuestions, (endTime - startTime) / 1000));
    }

    @Override
    public ArrayList<String> getListQuizz() {
	// TODO r�cup�ration de la liste � partir d'un fichier
	ArrayList<String> tab = new ArrayList<String>();
	tab.addAll(Arrays.asList("Afghanistan:Kaboul", "Afrique du Sud:Pr�toria", "Albanie:Tirana", "Alg�rie:Alger",
		"Allemagne:Berlin", "Andorre:Andorre-la-Vieille", "Angola:Luanda", "Antigua-et-Barbuda:Saint John's",
		"Arabie saoudite:Riyad", "Argentine:Buenos Aires", "Arm�nie:Erevan", "Australie:Canberra",
		"Autriche:Vienne", "Azerba�djan:Bakou", "Bahamas:Nassau", "Bahre�n:Manama", "Bangladesh:Dacca",
		"Barbade:Bridgetown", "Belgique:Bruxelles", "B�lize:Belmopan", "B�nin:Porto-Novo", "Bhoutan:Thimphou",
		"Bi�lorussie:Minsk", "Birmanie:Naypyidaw", "Bosnie-Herz�govine:Sarajevo", "Botswana:Gaborone",
		"Br�sil:Brasilia", "Brunei:Bandar Seri Begawan", "Bulgarie:Sofia", "Burkina:Ouagadougou",
		"Burundi:Gitega", "Cambodge:Phnom Penh", "Cameroun:Yaound�", "Canada:Ottawa", "Cap-Vert:Praia",
		"Centrafrique:Bangui", "Chili:Santiago", "Chine:P�kin", "Chypre:Nicosie", "Colombie:Bogota",
		"Comores:Moroni", "Congo:Brazzaville", "R�publique d�mocratique du Congo:Kinshasa", "�les Cook:Avarua",
		"Cor�e du Nord:Pyongyang", "Cor�e du Sud:S�oul", "Costa Rica:San Jos�", "C�te d'Ivoire:Yamoussoukro",
		"Croatie:Zagreb", "Cuba:La Havane", "Danemark:Copenhague", "Djibouti:Djibouti",
		"R�publique dominicaine:Saint-Domingue", "Dominique:Roseau", "�gypte:Le Caire",
		"�mirats arabes unis:Abou Dabi", "�quateur:Quito", "�rythr�e:Asmara", "Espagne:Madrid",
		"Estonie:Tallinn", "Eswatini:Mbaban�", "�tats-Unis:Washington", "�thiopie:Addis Abeba", "Fidji:Suva",
		"Finlande:Helsinki", "France:Paris", "Gabon:Libreville", "Gambie:Banjul", "G�orgie:Tbilissi",
		"Ghana:Accra", "Gr�ce:Ath�nes", "Grenade:Saint-Georges", "Guat�mala:Guat�mala", "Guin�e:Conakry",
		"Guin�e �quatoriale:Malabo", "Guin�e-Bissao:Bissao", "Guyana:Georgetown", "Ha�ti:Port-au-Prince",
		"Honduras:T�gucigalpa", "Hongrie:Budapest", "Inde:New Delhi", "Indon�sie:Jakarta", "Irak:Bagdad",
		"Iran:T�h�ran", "Irlande:Dublin", "Islande:Reykjavik", "Italie:Rome", "Jama�que:Kingston",
		"Japon:Tokyo", "Jordanie:Amman", "Kazakhstan:Nour-Soultan", "K�nya:Nairobi", "Kirghizstan:Bichkek",
		"Kiribati:Bairiki", "Kosovo:Pristina", "Kowe�t:Kowe�t", "Laos:Vientiane", "L�sotho:Mas�ru",
		"Lettonie:Riga", "Liban:Beyrouth", "Lib�ria:Monrovia", "Libye:Tripoli", "Liechtenstein:Vaduz",
		"Lituanie:Vilnius", "Luxembourg:Luxembourg", "Mac�doine du Nord:Skopje", "Madagascar:Antananarivo",
		"Malaisie:Kuala Lumpur", "Malawi:Lilongw�", "Maldives:Mal�", "Mali:Bamako", "Malte:La Valette",
		"Maroc:Rabat", "�les Marshall:Delap-Uliga-Darrit", "Isra�l:J�rusalem", "Maurice:Port-Louis",
		"Mauritanie:Nouakchott", "Mexique:Mexico", "Micron�sie:Palikir", "Moldavie:Chisinau", "Monaco:Monaco",
		"Mongolie:Oulan-Bator", "Mont�n�gro:Podgorica", "Mozambique:Maputo", "Namibie:Windhoek", "Nauru:Yaren",
		"N�pal:Katmandou", "Nicaragua:Managua", "Niger:Niamey", "Nig�ria:Abuja", "Niue:Alofi", "Norv�ge:Oslo",
		"Nouvelle-Z�lande:Wellington", "Oman:Mascate", "Ouganda:Kampala", "Ouzb�kistan:Tachkent",
		"Pakistan:Islamabad", "Palaos:Melekeok", "Panama:Panama", "Papouasie-Nouvelle-Guin�e:Port Moresby",
		"Paraguay:Assomption", "Pays-Bas:Amsterdam", "P�rou:Lima", "Philippines:Manille", "Pologne:Varsovie",
		"Portugal:Lisbonne", "Qatar:Doha", "Roumanie:Bucarest", "Royaume-Uni:Londres", "Russie:Moscou",
		"Rwanda:Kigali", "Saint-Christophe-et-Ni�v�s:Basseterre", "Sainte-Lucie:Castries",
		"Saint-Marin:Saint-Marin", "Saint-Vincent-et-les-Grenadines:Kingstown", "Salomon:Honiara",
		"Salvador:San Salvador", "Samoa:Apia", "Sao Tom�-et-Principe:Sao Tom�", "S�n�gal:Dakar",
		"Serbie:Belgrade", "Seychelles:Victoria", "Sierra Leone:Freetown", "Singapour:Singapour",
		"Slovaquie:Bratislava", "Slov�nie:Ljubljana", "Somalie:Mogadiscio", "Soudan:Khartoum",
		"Soudan du Sud:Djouba", "Sri Lanka:Sri Jayewardenepura-Kotte", "Su�de:Stockholm", "Suisse:Berne",
		"Suriname:Paramaribo", "Syrie:Damas", "Tadjikistan:Douchanb�", "Tanzanie:Dodoma", "Tchad:Ndjamena",
		"Tch�quie:Prague", "Tha�lande:Bangkok", "Timor oriental:Dili", "Togo:Lom�", "Tonga:Nuku'alofa",
		"Trinit�-et-Tobago:Port-d'Espagne", "Tunisie:Tunis", "Turkm�nistan:Achgabat", "Turquie:Ankara",
		"Tuvalu:Vaiaku", "Ukraine:Kiev", "Uruguay:Mont�vid�o", "Vanuatu:Port-Vila", "Vatican:Vatican",
		"V�n�zu�la:Caracas", "Vietnam:Hano�", "Y�men:Sanaa", "Zambie:Lusaka", "Zimbabw�:Harar�"));
	return tab;
    }

}

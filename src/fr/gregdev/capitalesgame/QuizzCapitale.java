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
	// TODO récupération de la liste à partir d'un fichier
	ArrayList<String> tab = new ArrayList<String>();
	tab.addAll(Arrays.asList("Afghanistan:Kaboul", "Afrique du Sud:Prétoria", "Albanie:Tirana", "Algérie:Alger",
		"Allemagne:Berlin", "Andorre:Andorre-la-Vieille", "Angola:Luanda", "Antigua-et-Barbuda:Saint John's",
		"Arabie saoudite:Riyad", "Argentine:Buenos Aires", "Arménie:Erevan", "Australie:Canberra",
		"Autriche:Vienne", "Azerbaïdjan:Bakou", "Bahamas:Nassau", "Bahreïn:Manama", "Bangladesh:Dacca",
		"Barbade:Bridgetown", "Belgique:Bruxelles", "Bélize:Belmopan", "Bénin:Porto-Novo", "Bhoutan:Thimphou",
		"Biélorussie:Minsk", "Birmanie:Naypyidaw", "Bosnie-Herzégovine:Sarajevo", "Botswana:Gaborone",
		"Brésil:Brasilia", "Brunei:Bandar Seri Begawan", "Bulgarie:Sofia", "Burkina:Ouagadougou",
		"Burundi:Gitega", "Cambodge:Phnom Penh", "Cameroun:Yaoundé", "Canada:Ottawa", "Cap-Vert:Praia",
		"Centrafrique:Bangui", "Chili:Santiago", "Chine:Pékin", "Chypre:Nicosie", "Colombie:Bogota",
		"Comores:Moroni", "Congo:Brazzaville", "République démocratique du Congo:Kinshasa", "Îles Cook:Avarua",
		"Corée du Nord:Pyongyang", "Corée du Sud:Séoul", "Costa Rica:San José", "Côte d'Ivoire:Yamoussoukro",
		"Croatie:Zagreb", "Cuba:La Havane", "Danemark:Copenhague", "Djibouti:Djibouti",
		"République dominicaine:Saint-Domingue", "Dominique:Roseau", "Égypte:Le Caire",
		"Émirats arabes unis:Abou Dabi", "Équateur:Quito", "Érythrée:Asmara", "Espagne:Madrid",
		"Estonie:Tallinn", "Eswatini:Mbabané", "États-Unis:Washington", "Éthiopie:Addis Abeba", "Fidji:Suva",
		"Finlande:Helsinki", "France:Paris", "Gabon:Libreville", "Gambie:Banjul", "Géorgie:Tbilissi",
		"Ghana:Accra", "Grèce:Athènes", "Grenade:Saint-Georges", "Guatémala:Guatémala", "Guinée:Conakry",
		"Guinée équatoriale:Malabo", "Guinée-Bissao:Bissao", "Guyana:Georgetown", "Haïti:Port-au-Prince",
		"Honduras:Tégucigalpa", "Hongrie:Budapest", "Inde:New Delhi", "Indonésie:Jakarta", "Irak:Bagdad",
		"Iran:Téhéran", "Irlande:Dublin", "Islande:Reykjavik", "Italie:Rome", "Jamaïque:Kingston",
		"Japon:Tokyo", "Jordanie:Amman", "Kazakhstan:Nour-Soultan", "Kénya:Nairobi", "Kirghizstan:Bichkek",
		"Kiribati:Bairiki", "Kosovo:Pristina", "Koweït:Koweït", "Laos:Vientiane", "Lésotho:Maséru",
		"Lettonie:Riga", "Liban:Beyrouth", "Libéria:Monrovia", "Libye:Tripoli", "Liechtenstein:Vaduz",
		"Lituanie:Vilnius", "Luxembourg:Luxembourg", "Macédoine du Nord:Skopje", "Madagascar:Antananarivo",
		"Malaisie:Kuala Lumpur", "Malawi:Lilongwé", "Maldives:Malé", "Mali:Bamako", "Malte:La Valette",
		"Maroc:Rabat", "Îles Marshall:Delap-Uliga-Darrit", "Israël:Jérusalem", "Maurice:Port-Louis",
		"Mauritanie:Nouakchott", "Mexique:Mexico", "Micronésie:Palikir", "Moldavie:Chisinau", "Monaco:Monaco",
		"Mongolie:Oulan-Bator", "Monténégro:Podgorica", "Mozambique:Maputo", "Namibie:Windhoek", "Nauru:Yaren",
		"Népal:Katmandou", "Nicaragua:Managua", "Niger:Niamey", "Nigéria:Abuja", "Niue:Alofi", "Norvège:Oslo",
		"Nouvelle-Zélande:Wellington", "Oman:Mascate", "Ouganda:Kampala", "Ouzbékistan:Tachkent",
		"Pakistan:Islamabad", "Palaos:Melekeok", "Panama:Panama", "Papouasie-Nouvelle-Guinée:Port Moresby",
		"Paraguay:Assomption", "Pays-Bas:Amsterdam", "Pérou:Lima", "Philippines:Manille", "Pologne:Varsovie",
		"Portugal:Lisbonne", "Qatar:Doha", "Roumanie:Bucarest", "Royaume-Uni:Londres", "Russie:Moscou",
		"Rwanda:Kigali", "Saint-Christophe-et-Niévès:Basseterre", "Sainte-Lucie:Castries",
		"Saint-Marin:Saint-Marin", "Saint-Vincent-et-les-Grenadines:Kingstown", "Salomon:Honiara",
		"Salvador:San Salvador", "Samoa:Apia", "Sao Tomé-et-Principe:Sao Tomé", "Sénégal:Dakar",
		"Serbie:Belgrade", "Seychelles:Victoria", "Sierra Leone:Freetown", "Singapour:Singapour",
		"Slovaquie:Bratislava", "Slovénie:Ljubljana", "Somalie:Mogadiscio", "Soudan:Khartoum",
		"Soudan du Sud:Djouba", "Sri Lanka:Sri Jayewardenepura-Kotte", "Suède:Stockholm", "Suisse:Berne",
		"Suriname:Paramaribo", "Syrie:Damas", "Tadjikistan:Douchanbé", "Tanzanie:Dodoma", "Tchad:Ndjamena",
		"Tchéquie:Prague", "Thaïlande:Bangkok", "Timor oriental:Dili", "Togo:Lomé", "Tonga:Nuku'alofa",
		"Trinité-et-Tobago:Port-d'Espagne", "Tunisie:Tunis", "Turkménistan:Achgabat", "Turquie:Ankara",
		"Tuvalu:Vaiaku", "Ukraine:Kiev", "Uruguay:Montévidéo", "Vanuatu:Port-Vila", "Vatican:Vatican",
		"Vénézuéla:Caracas", "Vietnam:Hanoï", "Yémen:Sanaa", "Zambie:Lusaka", "Zimbabwé:Hararé"));
	return tab;
    }

}

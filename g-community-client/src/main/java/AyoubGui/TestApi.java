package AyoubGui;

import java.awt.Image;
import java.util.List;

import main.java.riotapi.RiotApi;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;
import com.robrua.orianna.type.core.staticdata.ChampionSpell;

import constant.staticdata.SpellData;

public class TestApi {
	public static void main(String[] args) {
		RiotAPI.setMirror(Region.EUW);
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");

		// Summoner summoner = RiotAPI.getSummonerByName("FatalElement");
		// System.out.println(summoner.getName() + " is a level " +
		// summoner.getLevel() + " summoner on the NA server.");
		List<Champion> champions = RiotAPI.getChampions();
		//List<ChampionSpell> spellall = RiotAPI.getChampions().get(0).getSpells().get(0).getImage();
		// System.out.println("He enjoys playing LoL on all different champions, like "
		// + champions.get((int)(champions.size() * Math.random())) + ".");

		// League challenger = RiotAPI.getChallenger(QueueType.RANKED_SOLO_5x5);
		// Summoner bestNA = challenger.getEntries().get(0).getSummoner();
		// System.out.println("He's much better at writing Java code than he is at LoL. He'll never be as good as "
		// + bestNA + ".");
		for (int i = 0; i < champions.size(); i++) {
			System.out.println(champions.get(i));
			/*List<com.robrua.orianna.type.core.staticdata.Skin> skins = champions
					.get(i).getSkins();
			for (int j = 0; j < skins.size(); j++) {
				System.out.println(skins.get(j));
			}*/
			String lol = RiotAPI.getChampions().get(i).getSpells().get(i).getImage().getFull();
			//System.out.println(champions.get(i).getImage());
			System.out.println(lol);

		}
	}
}
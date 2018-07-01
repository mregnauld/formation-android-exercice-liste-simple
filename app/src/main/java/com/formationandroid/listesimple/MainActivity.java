package com.formationandroid.listesimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
	
	// Vues :
	private RecyclerView recyclerView = null;
	private EditText editTextMemo = null;
	
	// Adapter :
	private MemosAdapter memosAdapter = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vues :
		recyclerView = findViewById(R.id.liste_memos);
		editTextMemo = findViewById(R.id.saisie_memo);
		
		// à ajouter pour de meilleures performances :
		recyclerView.setHasFixedSize(true);
		
		// layout manager, décrivant comment les items sont disposés :
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		
		// contenu d'exemple :
		List<Memo> listeMemos = new ArrayList<>();
		for (int a = 0 ; a < 20 ; a++)
		{
			listeMemos.add(new Memo("Mémo n°" + (a + 1)));
		}
		
		// adapter :
		memosAdapter = new MemosAdapter(listeMemos);
		recyclerView.setAdapter(memosAdapter);
	}
	
	/**
	 * Listener clic bouton valider.
	 * @param view Bouton valider
	 */
	public void onClickBoutonValider(View view)
	{
		// ajout du mémo :
		memosAdapter.ajouterMemo(new Memo(editTextMemo.getText().toString()));
		
		// animation de repositionnement de la liste (sinon on ne voit pas l'item ajouté) :
		recyclerView.smoothScrollToPosition(0);
		
		// on efface le contenu de la zone de saisie :
		editTextMemo.setText("");
	}
	
}

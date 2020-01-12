package com.formationandroid.listesimple;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MemosAdapter extends RecyclerView.Adapter<MemosAdapter.MemoViewHolder>
{
	
	// Liste d'objets métier :
	private List<Memo> listeMemos = null;
	
	
	/**
	 * Constructeur.
	 * @param listeMemos Liste de mémos
	 */
	public MemosAdapter(List<Memo> listeMemos)
	{
		this.listeMemos = listeMemos;
	}
	
	@Override
	public MemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View viewMemo = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo, parent, false);
		return new MemoViewHolder(viewMemo);
	}
	
	@Override
	public void onBindViewHolder(MemoViewHolder holder, int position)
	{
		holder.textViewIntitule.setText(listeMemos.get(position).intitule);
	}
	
	@Override
	public int getItemCount()
	{
		return listeMemos.size();
	}
	
	/**
	 * Ajout d'un mémo à la liste.
	 * @param memo Mémo
	 */
	public void ajouterMemo(Memo memo)
	{
		listeMemos.add(0, memo);
		notifyItemInserted(0);
	}
	
	
	/**
	 * ViewHolder.
	 */
	class MemoViewHolder extends RecyclerView.ViewHolder
	{
		
		// Vue intitulé mémo :
		TextView textViewIntitule = null;
		
		
		/**
		 * Constructeur.
		 * @param itemView Vue item
		 */
		MemoViewHolder(final View itemView)
		{
			super(itemView);
			textViewIntitule = itemView.findViewById(R.id.memo_intitule);

			// listener :
			itemView.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					// récupération du context depuis une vue :
					Context context = itemView.getContext();
					
					// affichage du toast :
					Toast.makeText(context, context.getString(R.string.main_message_position, getAdapterPosition()), Toast.LENGTH_LONG).show();
				}
			});
		}
		
	}
	
}

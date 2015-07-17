/*
 * Copyright (c) 2015 Zetra.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package id.zelory.benih.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by zetbaitsu on 7/10/15.
 */
public class BenihViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
        View.OnLongClickListener
{
    private BenihRecyclerAdapter.OnItemClickListener itemClickListener;
    private BenihRecyclerAdapter.OnLongItemClickListener longItemClickListener;

    public BenihViewHolder(View itemView, BenihRecyclerAdapter.OnItemClickListener itemClickListener, BenihRecyclerAdapter.OnLongItemClickListener longItemClickListener)
    {
        super(itemView);
        this.itemClickListener = itemClickListener;
        this.longItemClickListener = longItemClickListener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (itemClickListener != null)
        {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    protected void log(String message)
    {
        try
        {
            Log.d(getClass().getSimpleName(), message);
        } catch (Exception e)
        {
            Log.d(getClass().getSimpleName(), "Null message.");
        }
    }

    @Override
    public boolean onLongClick(View v)
    {
        if (longItemClickListener != null)
        {
            longItemClickListener.onLongItemClick(v, getAdapterPosition());
            return true;
        }

        return false;
    }
}

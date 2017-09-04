package com.example.brunoandrade.tabajaras.ui.notification.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.brunoandrade.tabajaras.R;
import com.example.brunoandrade.tabajaras.model.Data;
import com.example.brunoandrade.tabajaras.model.DataMessageRequest;

import java.util.List;

/**
 * Created by Pablo on 26/03/2017.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private final TouchListenerCallback callback;
    private List<DataMessageRequest> messagesList;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView messageTitle;
        TextView operadorName;
        TextView idCaixa;
        TextView seeMoreDatails;
        TextView timeMessage;
        Button btnDecline;
        Button btnAccept;

        public MyViewHolder( View view ) {
            super(view);
            this.messageTitle = (TextView) view.findViewById(R.id.message_title);
            this.operadorName = (TextView) view.findViewById(R.id.operator_name);
            this.idCaixa = (TextView) view.findViewById(R.id.id_caixa);
            this.seeMoreDatails = (TextView) view.findViewById(R.id.see_more_datails);
            this.timeMessage = (TextView) view.findViewById(R.id.time_message);
            this.btnAccept = (Button) view.findViewById(R.id.btn_accept);
            this.btnDecline = (Button) view.findViewById(R.id.btn_decline);

            this.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    callback.onClickAccept(v,position);
                }
            });
            this.btnDecline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    callback.onClickDecline(v,position);
                }
            });
        }
    }

    public NotificationAdapter(List<DataMessageRequest> messagesList, TouchListenerCallback callback) {
        this.messagesList = messagesList;
        this.callback  =  callback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType ) {
        View itemView = LayoutInflater.from( parent.getContext() ).inflate(R.layout.item_messages_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataMessageRequest dataMessageRequest = messagesList.get(position);
        Data data = dataMessageRequest.getData();
        holder.messageTitle.setText("Solicitação de cancelamento de venda.");
        holder.operadorName.setText("Solicitante: " + /*data.getMatriculaUsuario() + " - " + */data.getOperadora());
        holder.idCaixa.setText("Id caixa: " + data.getIdCaixa());
        holder.timeMessage.setText("Data: 10:55 - 01/06/2017");
        //todo - see late
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }


}

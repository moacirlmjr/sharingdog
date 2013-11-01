package br.com.sd.modelo;

import java.util.ArrayList;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class RacaDataModel extends ListDataModel<Raca> implements
		SelectableDataModel<Raca> {

	public RacaDataModel() {
	}

	public RacaDataModel(ArrayList<Raca> data) {
		super(data);
	}

	@Override
	public Raca getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		ArrayList<Raca> racas = (ArrayList<Raca>) getWrappedData();

		for (Raca raca : racas) {
			if (raca.getRaca().equals(rowKey))
				return raca;
		}
		return null;
	}

	@Override
	public Object getRowKey(Raca raca) {
		return raca.getRaca();
	}
}

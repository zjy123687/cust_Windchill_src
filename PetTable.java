package com.acme.mvc.builders;

import com.acme.Pet;
import com.acme.jca.AcmeManagerResource;
import com.ptc.core.components.descriptor.DescriptorConstants.ColumnIdentifiers;
import com.ptc.mvc.components.*;
import wt.fc.PersistenceHelper;
import wt.query.QuerySpec;
import wt.util.WTException;
import wt.util.WTMessage;
@ComponentBuilder("acme.pet.table")
public class PetTable extends AbstractComponentBuilder {
	static final String RESOURCE = AcmeManagerResource.class.getName();
	//取数据
	public Object buildComponentData(ComponentConfig arg0, ComponentParams arg1) throws Exception {

		return PersistenceHelper.manager.find(new QuerySpec(Pet.class));
	}
	//定义显示页面的样式
	public ComponentConfig buildComponentConfig(ComponentParams arg0) throws WTException {
		final ComponentConfigFactory factory = getComponentConfigFactory();
		final TableConfig table; {
			table = factory.newTableConfig();
			table.setType(Pet.class.getName());
			table.setLabel(WTMessage.getLocalizedMessage(RESOURCE,
			AcmeManagerResource.PET_TABLE_LABEL, null));
			table.setActionModel("pets list");
			table.setSelectable(true);
			table.setShowCount(true);
			table.setShowCustomViewLink(false);
			final ColumnConfig name; {
			name = factory.newColumnConfig(Pet.NAME, true);
			name.setInfoPageLink(true);
			name.setSortable(true);
			}
			table.addComponent(name);
			table.addComponent(getColumn(ColumnIdentifiers.INFO_ACTION, factory));
			table.addComponent(getColumn(ColumnIdentifiers.NM_ACTIONS, factory));
			table.addComponent(getColumn(ColumnIdentifiers.LAST_MODIFIED, factory));
			table.addComponent(getColumn(Pet.KIND, factory));
			table.addComponent(getColumn(Pet.DATE_OF_BIRTH, factory));
			table.addComponent(getColumn(Pet.FIXED, factory));
			}
			return table;
	}
	
	 public ColumnConfig getColumn(final String id, final ComponentConfigFactory
			factory) {
			final ColumnConfig column = factory.newColumnConfig(id, true);
			column.setSortable(false);
			return column;
			}

}

package com.acme.mvc.builders;
import wt.util.WTException;
import com.ptc.jca.mvc.builders.DefaultInfoComponentBuilder;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentId;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.InfoConfig;
import com.ptc.mvc.components.TypeBased;
@ComponentBuilder(ComponentId.INFOPAGE_ID)
@TypeBased("com.acme.Pet")
public class PetInfoBuilder extends DefaultInfoComponentBuilder {
    @Override
    protected InfoConfig buildInfoConfig(final ComponentParams params)
            throws WTException {
        final InfoConfig info = getComponentConfigFactory().newInfoConfig();
        info.setTabSet("petDetails");
        return info;
    } }
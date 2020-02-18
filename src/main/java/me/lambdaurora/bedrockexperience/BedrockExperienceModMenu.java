/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of BedrockExperience.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.bedrockexperience;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class BedrockExperienceModMenu implements ModMenuApi
{
    @Override
    public String getModId()
    {
        return BedrockExperience.NAMESPACE;
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return screen -> screen;
    }
}

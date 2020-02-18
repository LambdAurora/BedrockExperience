/*
 * AuroraKeystrokes
 * Copyright (C) 2019  LambdAurora
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.lambdaurora.bedrockexperience;

import com.electronwill.nightconfig.core.file.FileConfig;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the Bedrock Experience configuration.
 *
 * @author LambdAurora
 * @version 1.0.0
 * @since 1.0.0
 */
public class BedrockExperienceConfig
{
    private final FileConfig        config = FileConfig.builder("config/keystrokes.toml").concurrent().defaultResource("/config.toml").build();
    private final BedrockExperience mod;

    public BedrockExperienceConfig(@NotNull BedrockExperience mod)
    {
        this.mod = mod;
    }

    public void load()
    {
        this.config.load();
    }

    public void save()
    {
        this.config.save();
    }

    public boolean hasCoordinatesIndicator()
    {
        return this.config.getOrElse("coordinates_indicator.enable", true);
    }

    public boolean hasCoordinatesIndicatorBackground()
    {
        return this.config.getOrElse("coordinates_indicator.background", true);
    }

    public int getCoordinatesDecimalsAmount()
    {
        return this.config.getOrElse("coordinates_indicator.decimals", 0);
    }
}

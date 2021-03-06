/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

data class SootheData(
    val name: String,
    val imageUrl: String
)

val favorities = listOf<SootheData>(
    SootheData(
        name = "Short mantras",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_night_wind_down.jpeg"
    ),
    SootheData(
        name = "Nature meditations",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_nature_meditation.jpeg"
    ),
    SootheData(
        name = "Stress and anxiety",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_stress_anxiety.jpeg"
    ),
    SootheData(
        name = "Self-massage",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_self_message.jpeg"
    ),
    SootheData(
        name = "Overwhelmed",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_overwhelmed.jpeg"
    ),
    SootheData(
        name = "Nightly wind down",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_night_wind_down.jpeg"
    )
)

val body = listOf<SootheData>(
    SootheData(
        name = "Inversions",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_inversions.jpeg"
    ),
    SootheData(
        name = "Quick yoga",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_quick_yoga.jpeg"
    ),
    SootheData(
        name = "Stretching",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_stretching.jpeg"
    ),
    SootheData(
        name = "Tabata",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_tabata.jpeg"
    ),
    SootheData(
        name = "Pre-natal yoga",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_pre_natal_yoga.jpeg"
    )
)

val mind = listOf<SootheData>(
    SootheData(
        name = "With kids",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_with_kids.jpeg"
    ),
    SootheData(
        name = "Aromatherapy",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_aromatherapy.jpeg"
    ),
    SootheData(
        name = "On the go",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_on_the_go.jpeg"
    ),
    SootheData(
        name = "With pets",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_with_pets.jpeg"
    ),
    SootheData(
        name = "High stress",
        imageUrl = "https://sanctus.sfo2.digitaloceanspaces.com/compose/img_high_stress.jpeg"
    )
)

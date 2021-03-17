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
package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.extension.toPair
import com.example.androiddevchallenge.model.SootheData
import com.example.androiddevchallenge.model.body
import com.example.androiddevchallenge.model.favorities
import com.example.androiddevchallenge.model.mind
import com.example.androiddevchallenge.ui.theme.*
import dev.chrisbanes.accompanist.coil.CoilImage


const val HOME_SCREEN_ID = "home_screen"


@Composable
fun HomeScreen(
    favoriteItems: List<SootheData> = favorities,
    bodyItems: List<SootheData> = body,
    mindItems: List<SootheData> = mind
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        },
        floatingActionButton = {
            FloatingActionButtonView()
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        drawerElevation = 4.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = margin56),
            ) {
                Search()
                Favorites(
                   items = favoriteItems
                )
                Body(
                    items = bodyItems
                )
                Mind(
                    items = mindItems
                )
            }
        }
    }
}

data class TabScreen(
    val name: String,
    val iconId: Int
)

val tabs = listOf<TabScreen>(
    TabScreen(
        name = "HOME",
        iconId = R.drawable.ic_baseline_spa_24
    ),
    TabScreen(
        name = "PROFILE",
        iconId = R.drawable.ic_baseline_account_circle_24
    )
)

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        val selectedColor = if (isSystemInDarkTheme()) taupe100 else taupe800

        tabs.forEachIndexed { index, tabScreen ->
            BottomNavigationItem(
                selected = index == 0,
                onClick = {

                },
                icon = {
                    Icon(
                        painter = painterResource(tabScreen.iconId),
                        contentDescription = tabScreen.name,
                    )
                },
                selectedContentColor = selectedColor,
                unselectedContentColor = selectedColor.copy(alpha = .5f),
                label = {
                    Text(text = tabScreen.name)
                }
            )
        }
    }
}

@Composable
fun FloatingActionButtonView() {
    FloatingActionButton(
        onClick = {

        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(R.drawable.ic_baseline_play_arrow_24),
            contentDescription = "Play",
            tint = MaterialTheme.colors.onPrimary,
        )
    }

    Column(
        modifier = Modifier
            .size(56.dp)
            .shadow(elevation = 4.dp, shape = CircleShape)
            .clip(shape = CircleShape)
            .background(MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(R.drawable.ic_baseline_play_arrow_24),
            contentDescription = "Play",
            tint = MaterialTheme.colors.onPrimary,
        )
    }
}

@Composable
fun Search() {
    val search = remember { mutableStateOf("") }

    TextField(
        value = search.value,
        onValueChange = {
            search.value = it
        },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_baseline_search_24),
                contentDescription = "welcome"
            )
        },
        modifier = Modifier
            .padding(start = margin16, end = margin16, bottom = margin40)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.onSurface),
        label = { Text("Password") }
    )
}

@Composable
fun Favorites(
    items: List<SootheData>
) {
    val pairList = items
        .withIndex()
        .groupBy { it.index / 2 }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = margin40)
    ) {
        Text(
            modifier = Modifier
                .padding(start = margin16),
            text = "FAVORITE COLLECTIONS",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        LazyRow(
            contentPadding = PaddingValues(margin16)
        ) {
            pairList.map {  pair ->
                item {
                    Column {
                        FavoriteCard(
                            item = pair.value[0].value,
                            marginBottom = margin8
                        )
                        pair.value[1]?.value?.let {
                            FavoriteCard(
                                item = pair.value[1].value
                            )
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun FavoriteCard(
    item: SootheData,
    marginBottom: Dp = 0.dp
) {
    val colorBg = if (isSystemInDarkTheme()) gray800 else white

    Row(
        modifier = Modifier
            .padding(bottom = marginBottom, end = margin8)
            .height(56.dp)
            .width(192.dp)
            .clip(RoundedCornerShape(size = 4.dp))
            .background(colorBg),
        verticalAlignment = Alignment.CenterVertically

    ) {
        CoilImage(
            data = item.imageUrl,
            modifier = Modifier
                .padding(end = margin8)
                .height(56.dp)
                .width(56.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 4.dp,
                        bottomStart = 4.dp
                    )
                ),
            contentScale = ContentScale.FillBounds,
            contentDescription = item.toString()
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Left
        )
    }
}
@Composable
fun Body(
    items: List<SootheData>
) {
    Column(
        modifier = Modifier
            .padding(bottom = margin40)
    ) {
        Text(
            modifier = Modifier
                .padding(start = margin16),
            text = "ALIGN YOUR BODY",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        LazyRow(
            contentPadding = PaddingValues(margin16)
        ) {
            items(items) { item ->
                RoundedImageText(
                    item =  item
                )
            }
        }
    }
}

@Composable
fun Mind(
    items: List<SootheData>
) {
    Column(
        modifier = Modifier
            .padding(bottom = margin40)
    ) {
        Text(
            modifier = Modifier
                .padding(start = margin16),
            text = "ALIGN YOUR MIND",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        LazyRow(
            contentPadding = PaddingValues(margin16)
        ) {
            items(items) { item ->
                RoundedImageText(
                    item =  item
                )
            }
        }
    }
}

@Composable
fun RoundedImageText(
    item: SootheData
) {
    Column(
        modifier = Modifier
            .padding(end = margin8)
            .height(112.dp)
            .width(88.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            data = item.imageUrl,
            modifier = Modifier
                .padding(bottom = margin8)
                .height(88.dp)
                .width(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = item.toString()
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
    }
}

@Preview("HomeScreenPreview")
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


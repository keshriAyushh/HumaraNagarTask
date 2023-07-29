package com.ayush.humaranagartask

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayush.humaranagartask.ui.theme.BackgroundColor
import com.ayush.humaranagartask.ui.theme.ButtonColor
import com.google.accompanist.pager.HorizontalPagerIndicator


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(images: List<ImageData>) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(BackgroundColor)
            .padding(15.dp)
    ) {

        ShowImages(
            images
        )

        Spacer(modifier = Modifier.height(50.dp))

        val phoneText = rememberSaveable {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = phoneText.value ,
            onValueChange = {
                phoneText.value = it
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth(1f),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                focusedBorderColor = ButtonColor,
                unfocusedBorderColor = Color.Black,
                placeholderColor = Color.Gray,
                cursorColor = Color.Black
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.phoneNumber),
                    color = Color.Gray,
                    fontFamily = FontFamily(Font(R.font.sans_reg))
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            colors = ButtonDefaults.buttonColors(ButtonColor),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 9.dp),
            onClick = {

            },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(1f)
        ) {
            Text(
                text = stringResource(R.string.button_text),
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.sans_reg))
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.terms_conditions),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.sans_light)),
            color = Color.Gray
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowImages(images: List<ImageData>) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        pageCount = 4,
        state = pagerState,
        pageSize = PageSize.Fill
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 100.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(images[it].image),
                    contentDescription = "image_1",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(300.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = images[it].text,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.sans_bold)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    pageCount = 4,
                    activeColor = ButtonColor
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFunc() {
    OnboardingScreen(
        listOf(
            ImageData(
                R.drawable.img2,
                "We Solve"
            )
        )
    )
}
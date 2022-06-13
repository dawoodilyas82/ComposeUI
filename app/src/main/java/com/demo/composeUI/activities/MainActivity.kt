package com.demo.composeUI.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.composeUI.R
import com.demo.composeUI.models.Message
import com.demo.composeUI.models.SampleData
import com.demo.composeUI.ui.theme.ComposeUITheme

class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Text("Hello World")
//        }
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MessageCard("World")
//        }
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MessageCard("Text 1")
//            MessageCard("Text 2")
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                MyApp()
            }
        }
    }

//    @Composable
//    private fun MyApp() {
//        Column() {
//            MessageCard("Text 1")
//            MessageCard("Text 2")
//        }
////        Row() {
////            MessageCard("Text 1")
////            MessageCard("Text 2")
////        }
////        Box() {
////            MessageCard("Text 1")
////            MessageCard("Text 2")
////        }
//    }

//    @Composable
//    private fun MyApp() {
//        Row(modifier = Modifier
//            .padding(all = 8.dp)
//        ) {
//            Image(
//                painter = painterResource(R.drawable.test_image),
//                contentDescription = "Contact profile picture",
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//            )
//
//            Spacer(modifier = Modifier.width(8.dp))
//
//            Column {
//                Text(text = "Author Name")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = "This is the body of the text")
//            }
//        }
//    }

    @Composable
    private fun MyApp() {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
//            item {
////                Header
//            }

            items(SampleData.conversationSample) { message ->
                ConversationTile(message)
            }
//            item {
//                Footer
//            }
//            itemsIndexed(SampleData.conversationSample) { index, message ->
//                ConversationTile(message)
//            }
        }
//        Column() {
//            SampleData.conversationSample.forEach {
//                ConversationTile(it)
//            }
//        }
    }

    @Composable
    private fun ConversationTile(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.test_image),
                contentDescription = "Contact profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

//            var isExpanded by remember  { mutableStateOf(false) }
            var isExpanded by rememberSaveable { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.secondary
                else MaterialTheme.colors.surface,
            )
            Column(
                modifier = Modifier.clickable { isExpanded = !isExpanded },
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message.title,
                    color = MaterialTheme.colors.primaryVariant,
//                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.body2
                    )
                }
            }


//            OutlinedButton(
//                onClick = { /* TODO */ }
//            ) {
//                Text("Show more")
//            }
        }
    }

    @Composable
    fun MessageCard(message: String) {
        Text(message)
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMessageCard() {
        MyApp()
    }
}


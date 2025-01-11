package com.example.notespro;
import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Locale;

public class Utility {

    static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    static CollectionReference getCollectionReferenceForNotes() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            return FirebaseFirestore.getInstance().collection("notes")
                    .document(currentUser.getUid()).collection("my_notes");
        } else {
            // Handle the case where the user is not authenticated
            return null;
        }
    }

    static String timestampToString(Timestamp timestamp) {
        // Use DateFormat.getDateInstance() for local formatting
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        return dateFormat.format(timestamp.toDate());
    }

    public static void showToast(LoginActivity loginActivity, String s, int lengthShort) {
    }

    public static void showToast(CreateAccountActivity createAccountActivity, String s, int lengthShort) {
    }
}

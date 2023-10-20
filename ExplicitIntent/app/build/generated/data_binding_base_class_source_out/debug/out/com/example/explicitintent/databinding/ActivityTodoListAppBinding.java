// Generated by view binder compiler. Do not edit!
package com.example.explicitintent.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.explicitintent.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTodoListAppBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button addTodoBtn;

  @NonNull
  public final EditText desId;

  @NonNull
  public final ListView listItem;

  @NonNull
  public final EditText nameId;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  private ActivityTodoListAppBinding(@NonNull ConstraintLayout rootView, @NonNull Button addTodoBtn,
      @NonNull EditText desId, @NonNull ListView listItem, @NonNull EditText nameId,
      @NonNull TextView textView2, @NonNull TextView textView3) {
    this.rootView = rootView;
    this.addTodoBtn = addTodoBtn;
    this.desId = desId;
    this.listItem = listItem;
    this.nameId = nameId;
    this.textView2 = textView2;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTodoListAppBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTodoListAppBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_todo_list_app, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTodoListAppBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addTodoBtn;
      Button addTodoBtn = ViewBindings.findChildViewById(rootView, id);
      if (addTodoBtn == null) {
        break missingId;
      }

      id = R.id.des_id;
      EditText desId = ViewBindings.findChildViewById(rootView, id);
      if (desId == null) {
        break missingId;
      }

      id = R.id.listItem;
      ListView listItem = ViewBindings.findChildViewById(rootView, id);
      if (listItem == null) {
        break missingId;
      }

      id = R.id.name_id;
      EditText nameId = ViewBindings.findChildViewById(rootView, id);
      if (nameId == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new ActivityTodoListAppBinding((ConstraintLayout) rootView, addTodoBtn, desId,
          listItem, nameId, textView2, textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

1.创建一个FragmentPreferences类继承PreferenceFragment， addPreferencesFromResource(R.xml.lnline)用来从xml加载选项
public class FragmentPreferences extends PreferenceFragment{
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.lnline);
    }

}

2.主文件MainActivity.java，加载并实例化FragmentPreferences。
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentPreferences fragmentPreferences = new FragmentPreferences();

        transaction.replace(android.R.id.content, fragmentPreferences).addToBackStack(null);
        transaction.commit();

    }

}
3.设置xml布局。
使用<PreferenceCategory>进行分组，一个<PreferenceCategory>就是一个类别，单个的<PreferenceCategory>可以放入任意的Preference控件。
1）CheckBoxPreference：复选框
2）EditTextPreference：编辑文本对话框
3）ListPreference：列表对话框
4）intent：意图

android:key 唯一标识符
android:title 大标题
android:summary标题下面的小字
android:entries 弹出的对话框中，列表显示的文本内容，注意哦，这里指定的是一个数组。
android:entryValues 与android:entries相对应的值
android:dialogTitle 弹出的对话框中的标题信息

<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <PreferenceCategory
        android:title="ln-line preferences">

    <CheckBoxPreference
        android:key="checkbox_preference"
        android:title="Checkbox Preference"
        android:summary="This is a checkbox"
        android:defaultValue="true"/>

    </PreferenceCategory>

    <PreferenceCategory
        android:title="Dialog-based preferences">

        <EditTextPreference
            android:dialogTitle="Enter your favorite animal"
            android:key="edittext_preference"
            android:summary="An example that uses an edit text dialog"
            android:title="Edit Text Preference" />

        <ListPreference
            android:dialogTitle="Choose one"
            android:entries="@array/entries_list_preference"
            android:entryValues="@array/entryvalues_list_preference"
            android:key="list_preferenc"
            android:summary="An example that uses a list dialog"
            android:title="List Preference" />

    </PreferenceCategory>

    <PreferenceCategory
        android:title="Launch preferences">
        <PreferenceScreen
            android:key="screen_preference"
            android:summary="shows another screen of preference"
            android:title="Screen preference">

            <CheckBoxPreference
                android:key="next_screen"
                android:title="Toggle preference"
                android:summary="Preference that is on the next screen but same hierarchy"/>
        </PreferenceScreen>

        <PreferenceScreen
            android:title="Intent preference"
            android:summary="launches an Activity from an Intent">
            <intent
                android:action="android.intent.action.VIEW"
                android:data="http://www.baidu.com"/>
        </PreferenceScreen>
    </PreferenceCategory>

    <PreferenceCategory
        android:title="Preference attributes">
        <CheckBoxPreference
            android:key="parent_checkBox"
            android:title="Parent checkBox preference"
            android:summary="This is visually a parent"/>
        <CheckBoxPreference
            android:dependency="parent_checkBox"
            android:key="child_checkBox"
            android:title="Child checkBox preference"
            android:summary="This is visually a child"
            android:layout="?android:attr/preferenceLayoutChild"/>

    </PreferenceCategory>
</PreferenceScreen>

运行结果：

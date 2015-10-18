package cn.elvea.web.multipart;

import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FileUploadProgressListener implements ProgressListener {
    public final static String DEFAULT_FILE_UPLOAD_PROGRESS_SESSION_KEY = "upload_session_key";

    private HttpSession session;

    public FileUploadProgressListener(HttpServletRequest request) {
        session = request.getSession();

        FileUploadProgress progress = new FileUploadProgress();
        session.setAttribute(DEFAULT_FILE_UPLOAD_PROGRESS_SESSION_KEY, progress);
    }

    private long megaBytes = -1;

    @Override
    public void update(final long pBytesRead, final long pContentLength, final int pItems) {
        long mBytes = pBytesRead / 1000000;
        if (megaBytes == mBytes) {
            return;
        }
        megaBytes = mBytes;
        System.out.println("We are currently reading item " + pItems);
        if (pContentLength == -1) {
            System.out.println("So far, " + pBytesRead + " bytes have been read.");
        } else {
            System.out.println("So far, " + pBytesRead + " of " + pContentLength
                    + " bytes have been read.");
        }

        FileUploadProgress status = (FileUploadProgress) session.getAttribute(DEFAULT_FILE_UPLOAD_PROGRESS_SESSION_KEY);
        status.setBytesRead(pBytesRead);
        status.setContentLength(pContentLength);
        status.setItems(pItems);
    }
}